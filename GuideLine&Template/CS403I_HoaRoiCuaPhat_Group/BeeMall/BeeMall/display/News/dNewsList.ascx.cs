using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BeeMall.App_Code;

namespace BeeMall.display.News
{
    public partial class dNewsList : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                LoadList();
            }
        }

        private void LoadList()
        {
            rptNewsDetail.DataSource = clsNews.GetNewsList();
            rptNewsDetail.DataBind();
        }
    }
}