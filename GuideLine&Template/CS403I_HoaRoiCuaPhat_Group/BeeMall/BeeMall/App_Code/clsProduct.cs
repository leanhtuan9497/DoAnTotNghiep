using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace BeeMall
{
    public class clsProduct
    {
        public static DataTable GetList()
        {
            return DataAccess.selectQuery("select * from Product_Categories");
        }

        public static DataTable GetListByProductID(int ProID)
        {
            return DataAccess.selectQuery("select * from Product_Categories where ProID=" + ProID);
        }

        public static void Insert(string ProductName, int Order, bool Active)
        {
            DataAccess.ExecuteNoneQuery("insert into Product_Categories values ('" + ProductName + "'," + Order + "," + "'" + Active + "')");
        }

        public static void Update(int ProID, string ProName, int Order, bool Active)
        {
            DataAccess.ExecuteNoneQuery("update Product_Categories set Name='" + ProName + "'," +
                "[Order]=" + Order + "," + "Active='" + Active + "' where ProID=" + ProID);
        }

        public static void Delete(int ProID)
        {
            DataAccess.ExecuteNoneQuery("delete from Product_Categories where ProID=" + ProID);
        }

        //Detail
        public static void InsertDetail(int ProID, string Name, string Desc, string Content, string Image, int Quantity, float Price, DateTime CreateDate, bool Active)
        {
            DataAccess.ExecuteNoneQuery("Insert into Product_Detail values (" + ProID + ",'" + Name + "','" + Desc + "','" +
                 Content + "','" + Image + "'," + Quantity + "," + Price + ",'" + CreateDate + "','" + Active + "')");
        }

        public static DataTable GetListProductDetail()
        {
            return DataAccess.selectQuery("select * from Product_Detail");
        }

        public static DataTable GetListProductCategory()
        {
            return DataAccess.selectQuery("select * from Product_Categories where active = 'true' order by [Order]");
        }
    }
}