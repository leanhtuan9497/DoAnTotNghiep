using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BeeMall.App_Code;

namespace BeeMall.admin.News
{
    public partial class NewsDetail : System.Web.UI.UserControl
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
            drpNewsCategory.DataSource = clsNews.GetList();
            drpNewsCategory.DataValueField = "CateID";
            drpNewsCategory.DataTextField = "CategoryName";
            drpNewsCategory.DataBind();
        }

        void LoadNewsDetail()
        {
            rptNewsDetail.DataSource = clsNews.GetListNewsDetail();
            rptNewsDetail.DataBind();
        }

        protected void btnUpdate_Click(object sender, EventArgs e)
        {
            //Upload Image
            string typefile = "";
            string file = "";
            if (fUp.FileName.Length>0)
            {
                if (fUp.PostedFile.ContentLength<5000000)
                {
                    if (fUp.PostedFile.ContentType.Equals("image/jpeg")|| fUp.PostedFile.ContentType.Equals("image/pjpeg")|| fUp.PostedFile.ContentType.Equals("image/x-png")|| fUp.PostedFile.ContentType.Equals("image/png")|| fUp.PostedFile.ContentType.Equals("image/gif")|| fUp.PostedFile.ContentType.Equals("image/x-shockwave-flash"))
                    {
                        typefile = Path.GetExtension(fUp.FileName).ToLower();
                        file = Path.GetFileName(fUp.PostedFile.FileName);
                        file = fUp.FileName.Replace(file, "BeeMall" + DateTime.Now.Hour + DateTime.Now.Year + DateTime.Now.Day + DateTime.Now.Minute + DateTime.Now.Second + typefile);
                        fUp.PostedFile.SaveAs(Server.MapPath("~/Image/") + file);
                    }
                }
            }

            //Them moi data
            if (!string.IsNullOrEmpty(txtTitle.Text.Trim()))
            {
                bool active = chkActive.Checked ? true : false;
                clsNews.InsertDetail(int.Parse(drpNewsCategory.SelectedValue.ToString()), txtTitle.Text.Trim(), 
                    txtDesc.Text.Trim(),txtContent.Text.Trim(),file, DateTime.Now, txtAuthor.Text.Trim(), active);
                Response.Redirect(Request.Url.ToString());
            }
        }

        protected void lnkUpdate_Click(object sender, EventArgs e)
        {
            mul.ActiveViewIndex = 1;
        }
    }
}