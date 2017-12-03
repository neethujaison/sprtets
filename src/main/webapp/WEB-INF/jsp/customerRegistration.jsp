<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><title>Add User Page</title>
<style>
.error {
color: red; font-weight: bold; 
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#selectCountry").change(function(){

    var countryNm = $(this).val();
    var countryId= countryNm.split(",")[0];
    alert(countryId);
    alert(countryNm);
    $.ajax({
        type: "GET",
        url: "getCities",
        data: {"countryId" : countryId },
        success: function(data){
        alert(3);
        alert(data);
            var slctCity = $("#selectCity"), option= "";
            slctSubcat.empty();

            for(var sb =0; sb<data.length; sb++){
                option = option + "<option value='" + data[sb].name + "'>" +data[sb].name + "</option>";
            }
            slctCity.append(option);
        },
        error:function(){
           alert("error");
        }
   });

});

});
</script>
</head>
<body>
<h2>Customer Registration</h2>
<form:form name="customerRegistrationForm" commandName="customerForm" action="processCustomerRegistration" method="post">
	<table>
				<h2>Personal Details</h2>
				<tr>
					<td>Enter Name</td>
					<td><form:input path="customer_name"></form:input></td>
					<td><form:errors path="customer_name" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter Address</td>
					<td><form:input path="customer_address"></form:input></td>
					<td><form:errors path="customer_address" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter Country</td>
					<td>
						
						<form:select path="country" id="selectCountry">
   							<form:option value="NONE" label="--- Select ---"/>
   							<form:options items="${countryList}" />
   							
						</form:select>
					</td>
					<td><form:errors path="country" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter City</td>
					<td><form:select path="city" id="selectCity">
   							<form:option value="NONE" label="--- Select ---"/>
   							<!--<form:options items="${cityList}" />-->
						</form:select></td>
					<td><form:errors path="city" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter Mobile Phone No</td>
					<td><form:input path="customer_phoneno"></form:input></td>
					<td><form:errors path="customer_phoneno" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter Date of Birth</td>
					<td><form:input path="customer_dob"></form:input></td>
					<td><form:errors path="customer_dob" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter Email</td>
					<td><form:input path="customer_email"></form:input></td>
					<td><form:errors path="customer_email" cssClass="error"/></td>
				</tr>
				
				
				<tr><td><h2>Document Details</h2></td></tr>
				<tr>
					<td>Enter ID Document Type</td>
					<td><form:input path="doctype_name"></form:input></td>
					<td><form:errors path="doctype_name" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter ID Document No</td>
					<td><form:input path="document_no"></form:input></td>
					<td><form:errors path="document_no" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter ID Document Issuing Country</td>
					<td><form:input path="document_country_name"></form:input></td>
					<td><form:errors path="document_country_name" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Enter UAE National Details</td>
					<td><form:input path="national_id"></form:input></td>
					<td><form:errors path="national_id" cssClass="error"/></td>
				</tr>
					<tr>

				<td><input type="submit" value="Add Customer" name="submitbtn" /></td>
			</tr>
	</table>			
</form:form>

</body>
</html>