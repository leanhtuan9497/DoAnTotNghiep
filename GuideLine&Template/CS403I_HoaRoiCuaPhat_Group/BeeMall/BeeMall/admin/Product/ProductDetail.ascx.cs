using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BeeMall.admin.Product
{
    public partial class ProductDetail : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                LoadNewsDetail();
                LoadDataDropDownList();
            }
        }

        private void LoadDataDropDownList()
        {
            drpProductCategory.DataSource = clsProduct.GetList();
            drpProductCategory.DataValueField = "ProID";
            drpProductCategory.DataTextField = "Name";
            drpProductCategory.DataBind();
        }

        void LoadNewsDetail()
        {
            rptProductDetail.DataSource = clsProduct.GetListProductDetail();
            rptProductDetail.DataBind();
        }

        protected void btnUpdate_Click(object sender, EventArgs e)
        {
            //Upload Image
            string typefile = "";
            string file = "";
            if (fUp.FileName.Length > 0)
            {
                if (fUp.PostedFile.ContentLength < 5000000)
                {
                    if (fUp.PostedFile.ContentType.Equals("image/jpeg") || fUp.PostedFile.ContentType.Equals("image/pjpeg") || fUp.PostedFile.ContentType.Equals("image/x-png") || fUp.PostedFile.ContentType.Equals("image/png") || fUp.PostedFile.ContentType.Equals("image/gif") || fUp.PostedFile.ContentType.Equals("image/x-shockwave-flash"))
                    {
                        typefile = Path.GetExtension(fUp.FileName).ToLower();
                        file = Path.GetFileName(fUp.PostedFile.FileName);
                        file = fUp.FileName.Replace(file, "BeeMall" + DateTime.Now.Hour + DateTime.Now.Year + DateTime.Now.Day + DateTime.Now.Minute + DateTime.Now.Second + typefile);
                        fUp.PostedFile.SaveAs(Server.MapPath("~/Image/") + file);
                    }
                }
            }

            //Them moi data
            if (!string.IsNullOrEmpty(txtName.Text.Trim()))
            {
                bool active = chkActive.Checked ? true : false;

                clsProduct.InsertDetail(int.Parse(drpProductCategory.SelectedValue.ToString()), txtName.Text.Trim(),
                    txtDesc.Text.Trim(), txtContent.Text.Trim(), file,int.Parse(txtQuantity.Text.ToString().Trim()),
                    float.Parse(txtPrice.Text.ToString().Trim()),DateTime.Now, active);
                Response.Redirect(Request.Url.ToString());
            }
        }

        protected void lnkUpdate_Click(object sender, EventArgs e)
        {
            mul.ActiveViewIndex = 1;
        }
    }
}