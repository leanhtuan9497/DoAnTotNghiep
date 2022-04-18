<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="NewsDetail.ascx.cs" Inherits="BeeMall.admin.News.NewsDetail" %>
<%@ Register Assembly="FreeTextBox" Namespace="FreeTextBoxControls" TagPrefix="FTB" %>
<form runat="server">
    <asp:MultiView ID="mul" ActiveViewIndex="0" runat="server">
        <asp:View ID="v0" runat="server">
            <%--view 1--%>
            <asp:Repeater ID="rptNewsDetail" runat="server">
                <HeaderTemplate>
                    <table>
                        <tr>
                            <td style="width: 100px;">Image</td>
                            <td style="width: 400px;">Title</td>
                            <td style="width: 100px">Author</td>
                            <td style="width: 100px;">Active</td>
                            <td></td>
                        </tr>
                </HeaderTemplate>
                <ItemTemplate>
                    <tr>
                        <td>
                            <img src='/image/<%#:Eval("Image") %>'  width="100px"/></td>
                        <td><%#:Eval("Title") %></td>
                        <td><%#:Eval("Author") %></td>
                        <td><%#:Eval("Active") %></td>
                        <td></td>
                    </tr>
                </ItemTemplate>
                <FooterTemplate>
                    </table>
                </FooterTemplate>
            </asp:Repeater>
            <div>
                <asp:LinkButton ID="lnkUpdate" runat="server" OnClick="lnkUpdate_Click" >Add New</asp:LinkButton></div>
        </asp:View>
        <%--end view 1--%>

        <asp:View ID="v1" runat="server">
            <%--view 2--%>
            <table>
                <tr>
                    <td style="width: 100px;">New Category</td>
                    <td style="width: 10px;"></td>
                    <td>
                        <asp:DropDownList ID="drpNewsCategory" runat="server"></asp:DropDownList></td>
                </tr>

                <tr>
                    <td>Title</td>
                    <td></td>
                    <td>
                        <asp:TextBox ID="txtTitle" runat="server" Style="width: 500px;"></asp:TextBox></td>
                </tr>

                <tr>
                    <td>Desc</td>
                    <td></td>
                    <td>
                        <asp:TextBox ID="txtDesc" runat="server" TextMode="MultiLine" Style="width: 500px;"></asp:TextBox></td>
                </tr>

                <tr>
                    <td>Content</td>
                    <td></td>
                    <td>
                        <FTB:FreeTextBox ID="txtContent" runat="server"></FTB:FreeTextBox>
                    </td>
                </tr>

                <tr>
                    <td>Image</td>
                    <td></td>
                    <td>
                        <asp:FileUpload ID="fUp" runat="server" /></td>
                </tr>

                <tr>
                    <td>Author</td>
                    <td></td>
                    <td>
                        <asp:TextBox ID="txtAuthor" runat="server" Style="width: 500px;"></asp:TextBox></td>
                </tr>

                <tr>
                    <td>Active</td>
                    <td></td>
                    <td>
                        <asp:CheckBox ID="chkActive" runat="server" /></td>
                </tr>

                <tr>
                    <td></td>
                    <td></td>
                    <td>
                        <asp:Button ID="btnUpdate" Text="Update" runat="server" OnClick="btnUpdate_Click" /></td>
                </tr>
            </table>
            <%--end table--%>
        </asp:View>
        <%--end view1--%>
    </asp:MultiView><%--end multiview--%>
</form>

