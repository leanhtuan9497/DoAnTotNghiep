using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BeeMall.App_Code;
namespace BeeMall.admin.News
{
    public partial class NewsCategory : System.Web.UI.UserControl
    {
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                LoadData();
            }
        }

        private void LoadData()
        {
            rptNewsCategory.DataSource = clsNews.GetList();
            rptNewsCategory.DataBind();
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            if (hdInsert.Value=="insert")
            {
                if (!string.IsNullOrEmpty(txtCategoryName.Text.Trim()))
                {
                    bool active = chkActive.Checked ? true : false;
                    clsNews.Insert(txtCategoryName.Text.Trim(), int.Parse(txtOrder.Text.Trim()), active);
                    Response.Redirect(Request.Url.ToString());//Tránh trường hợp refresh trang thêm nhiều lần
                }
            }         
            else//update
            {
                if (!string.IsNullOrEmpty(txtCategoryName.Text.Trim()))
                {
                    bool active = chkActive.Checked ? true : false;
                    try
                    {
                        clsNews.Update(int.Parse(hdCategoryID.Value), txtCategoryName.Text.Trim(), int.Parse(txtOrder.Text.Trim()), active);
                    }
                    catch (SqlException err)
                    {

                        Response.Write("<b>Error</b>" + err.Message);
                    }
                    
                    Response.Redirect(Request.Url.ToString());//Tránh trường hợp refresh trang thêm nhiều lần
                }
            }
        }

        protected void lnkAddNew_Click1(object sender, EventArgs e)
        {
            hdInsert.Value = "insert";
            mul.ActiveViewIndex = 1;
        }

        protected void rptNewsCategory_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            DataTable dt = new DataTable();
            switch (e.CommandName.ToString())
            {
                case "update":
                    dt = clsNews.GetListByCategoryID(int.Parse(e.CommandArgument.ToString()));
                    if (dt.Rows.Count>0)
                    {
                        txtCategoryName.Text = dt.Rows[0]["CategoryName"].ToString();
                        txtOrder.Text = dt.Rows[0]["Order"].ToString();
                        chkActive.Checked = ((bool)dt.Rows[0]["Active"]) ? true : false;
                        hdCategoryID.Value = e.CommandArgument.ToString();
                        hdInsert.Value = "update";
                        mul.ActiveViewIndex = 1;
                    }
                    break;
                case "delete":
                    dt = clsNews.GetListByCategoryID(int.Parse(e.CommandArgument.ToString()));
                    if (dt.Rows.Count > 0)
                    {
                        clsNews.Delete(int.Parse(e.CommandArgument.ToString()));
                        Response.Redirect(Request.Url.ToString());
                    }
                    break;
            }
        }

        protected void lnkDelete_Load(object sender, EventArgs e)
        {
            ((LinkButton)sender).Attributes["onclick"] = "return confirm('Delete selected Category?')";
        }
    }
}