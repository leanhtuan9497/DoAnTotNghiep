<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="ProductCategory.ascx.cs" Inherits="BeeMall.admin.Product.ProductCategory" %>
<div>DANH SÁCH LOẠI SẢN PHẨM</div>
<form runat="server">
    <asp:MultiView ID="mul" ActiveViewIndex="0" runat="server">
        <asp:View ID="v1" runat="server">
            <div>
                <asp:Repeater ID="rptProductCategory" runat="server" OnItemCommand="rptProductCategory_ItemCommand">
                    <HeaderTemplate>
                        <table style="width: 100%;">
                            <tr>
                                <td style="width: 300px;">Category Product Name</td>
                                <td style="width: 50px;">Order</td>
                                <td style="width: 100px;">Active</td>
                                <td></td>
                            </tr>
                    </HeaderTemplate>
                    <%--end headertemplate--%>
                    <ItemTemplate>
                        <tr>
                            <td>
                                <asp:LinkButton ID="lnkUpdate" CommandName="update" runat="server" CommandArgument='<%#:Eval("ProID") %>'><%#:Eval("Name") %></asp:LinkButton>
                            </td>
                            <td><%#:Eval("Order") %></td>
                            <td><%#:Eval("Active") %></td>
                            <td>
                                <asp:LinkButton ID="lnkDel" CommandName="del" runat="server" CommandArgument='<%#:Eval("ProID") %>' OnLoad="lnkDel_Load">Xóa</asp:LinkButton></td>
                        </tr>

                    </ItemTemplate>
                    <%--end itemtemplate--%>
                    <FooterTemplate>
                        </table><%--end table--%>
                    </FooterTemplate>
                    <%--end footertemplate--%>
                </asp:Repeater>
                <%--end repeater--%>
            </div>
            <div>
                <asp:LinkButton ID="lnkAddNew" runat="server" OnClick="lnkAddNew_Click1">Add new</asp:LinkButton>
            </div>
        </asp:View>
        <%--end view 1--%>
        <asp:View ID="v2" runat="server">
            <asp:HiddenField ID="hdProductCategoryID" runat="server" />
            <asp:HiddenField ID="hdInsert" runat="server" />
            <table>
                <tr>
                    <td>Product Category Name</td>
                    <td>
                        <asp:TextBox ID="txtProductCateName" runat="server"></asp:TextBox></td>
                </tr>
                <tr>
                    <td>Order</td>
                    <td>
                        <asp:TextBox ID="txtOrder" runat="server"></asp:TextBox></td>
                </tr>
                <tr>
                    <td>Active</td>
                    <td>
                        <asp:CheckBox ID="chkActive" Checked="true" runat="server" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <asp:Button ID="btnSave" Text="Cập nhật" runat="server" OnClick="btnSave_Click" /></td>
                </tr>
            </table>
            <%--end table--%>
        </asp:View>
        <%--end view 2--%>
    </asp:MultiView>
</form>
