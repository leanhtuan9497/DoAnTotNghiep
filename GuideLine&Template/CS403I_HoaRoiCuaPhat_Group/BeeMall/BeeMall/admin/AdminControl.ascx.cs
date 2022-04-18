using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BeeMall.admin
{
    public partial class AdminControl : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string s = Request["f"];
            switch (s)
            {
                case "news":
                    plLoad.Controls.Add(LoadControl("News/NewsControl.ascx"));
                    break;
                case "product":
                    plLoad.Controls.Add(LoadControl("Product/ProductControl.ascx"));
                    break;
                    
            }
        }
    }
}