using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BeeMall.admin.Product
{
    public partial class ProductControl : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string fs = Request["fs"];
            switch (fs)
            {
                case "del":
                    Controls.Add(LoadControl("ProductDetail.ascx"));
                    break;
                default:
                    Controls.Add(LoadControl("ProductCategory.ascx"));
                    break;
            }
        }
    }
}