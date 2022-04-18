using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BeeMall.App_Code;
namespace BeeMall.display.News
{
    public partial class dNewsDetail : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                LoadDetail();
            }
        }

        private void LoadDetail()
        {
            string id = Request["id"];
            DataTable dt = new DataTable();
            dt = clsNews.GetNewsDetail(int.Parse(id));
            if (dt.Rows.Count > 0)
            {
                ltTitle.Text = dt.Rows[0]["Title"].ToString();
                ltDesc.Text = dt.Rows[0]["Desc"].ToString();
                ltContent.Text = dt.Rows[0]["Content"].ToString();
                ltAuthor.Text = dt.Rows[0]["Author"].ToString();

                //dt = clsNews.GetNewsDetailOrther(int.Parse(id));
                //if (dt.Rows.Count > 0)
                //{
                //    rptNewsList.DataSource = dt;
                //    rptNewsList.DataBind();
                //}
            }
        }

    }
}