using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BeeMall.admin.News
{
    public partial class NewsControl : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string fs = Request["fs"];
            switch (fs)
            {
                case "des":
                    Controls.Add(LoadControl("NewsDetail.ascx"));
                    break;
                default:
                    Controls.Add(LoadControl("NewsCategory.ascx"));
                    break;
            }
            
        }
    }
}