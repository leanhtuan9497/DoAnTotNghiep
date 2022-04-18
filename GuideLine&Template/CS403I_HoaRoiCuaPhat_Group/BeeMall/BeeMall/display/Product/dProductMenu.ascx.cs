using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BeeMall.App_Code;
namespace BeeMall.display.Product
{
    public partial class dProductMenu : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                LoadProductCate();
            }
        }

        private void LoadProductCate()
        {
            DataTable dt = new DataTable();
            dt = clsProduct.GetListProductCategory();
            if (dt.Rows.Count > 0)
            {
                rptProductList.DataSource = dt;
                rptProductList.DataBind();
            }
        }
    }
}