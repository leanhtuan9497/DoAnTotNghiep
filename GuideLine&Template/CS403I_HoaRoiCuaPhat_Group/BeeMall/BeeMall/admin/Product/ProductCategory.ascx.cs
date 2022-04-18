using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BeeMall.admin.Product
{
    public partial class ProductCategory : System.Web.UI.UserControl
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
            rptProductCategory.DataSource = clsProduct.GetList();
            rptProductCategory.DataBind();
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            if (hdInsert.Value == "insert")
            {
                if (!string.IsNullOrEmpty(txtProductCateName.Text.Trim()))
                {
                    bool active = chkActive.Checked ? true : false;
                    clsProduct.Insert(txtProductCateName.Text.Trim(), int.Parse(txtOrder.Text.Trim()), active);
                    Response.Redirect(Request.Url.ToString());//Tránh trường hợp refresh trang thêm nhiều lần
                }
            }
            else//update
            {
                if (!string.IsNullOrEmpty(txtProductCateName.Text.Trim()))
                {
                    bool active = chkActive.Checked ? true : false;
                    try
                    {
                        clsProduct.Update(int.Parse(hdProductCategoryID.Value), txtProductCateName.Text.Trim(), int.Parse(txtOrder.Text.Trim()), active);
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

        protected void rptProductCategory_ItemCommand(object source, RepeaterCommandEventArgs e)
        {
            DataTable dt = new DataTable();
            switch (e.CommandName.ToString())
            {
                case "update":
                    dt = clsProduct.GetListByProductID(int.Parse(e.CommandArgument.ToString()));
                    if (dt.Rows.Count > 0)
                    {
                        txtProductCateName.Text = dt.Rows[0]["Name"].ToString();
                        txtOrder.Text = dt.Rows[0]["Order"].ToString();
                        chkActive.Checked = ((bool)dt.Rows[0]["Active"]) ? true : false;
                        hdProductCategoryID.Value = e.CommandArgument.ToString();
                        hdInsert.Value = "update";
                        mul.ActiveViewIndex = 1;
                    }
                    break;
                case "del":
                    dt = clsProduct.GetListByProductID(int.Parse(e.CommandArgument.ToString()));
                    if (dt.Rows.Count > 0)
                    {
                        clsProduct.Delete(int.Parse(e.CommandArgument.ToString()));
                        Response.Redirect(Request.Url.ToString());
                    }
                    break;
            }
        }

        protected void lnkDel_Load(object sender, EventArgs e)
        {
            ((LinkButton)sender).Attributes["onclick"] = "return confirm('Delete selected Category?')";
        }
    }
}