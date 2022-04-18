using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BeeMall.display.News
{
    public partial class dNewsControl : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string fs = Request["fs"];
            switch (fs)
            {
                case "del":
                    Controls.Add(LoadControl("dNewsDetail.ascx"));
                    break;
                default:
                    Controls.Add(LoadControl("dNewsList.ascx"));
                    break;
            }
        }
    }
}