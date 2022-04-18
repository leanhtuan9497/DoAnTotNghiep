using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BeeMall
{
    public partial class Home1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            switch (Request["f"])
            {
                case "news":
                    Controls.Add(LoadControl("display/News/dNewsControl.ascx"));
                    break;
                case "contact":
                    Controls.Add(LoadControl("display/Utilities/dContact.ascx"));
                    break;
                default:
                    Controls.Add(LoadControl("display/Utilities/dIndex.ascx"));
                    break;
            }
        }
    }
}