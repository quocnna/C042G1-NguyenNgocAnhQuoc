<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%--<%!--%>
<%--    private CustomerService customerService = CustomerServiceFactory.getInstance();--%>
<%--%>--%>
<%--<%--%>
<%--    Long id = Long.valueOf(request.getParameter("id"));--%>
<%--    Customer customer = customerService.findOne(id);--%>
<%--%>--%>
<form action="/customers" method="post">
<fieldset>
    <legend>Customer Information</legend>
<%--    <input type="hidden" name="id" value="<%= customer.getId() %>">--%>
    <input type="hidden" name="id" value="${customer.id}">
    <table>
        <tr>
            <td>Id</td>
            <td>
<%--                <%= customer.getId() %>--%>
    ${customer.id}
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
<%--                <input type="text" name="name" value="<%= customer.getName() %>">--%>
    <input type="text" name="name" value="${customer.name}">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
<%--                <input type="text" name="email" value="<%= customer.getEmail() %>">--%>
    <input type="text" name="email" value="${customer.email}">
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
<%--                <input type="text" name="address" value="<%= customer.getAddress() %>">--%>
    <input type="text" name="address" value="${customer.address}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</fieldset>
</form>
<a href="/customers">Back to list</a>.