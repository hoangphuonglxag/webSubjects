<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Thanks for Joining</title>
</head>
<body>
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>
    <p>Email: ${user.email}</p>
    <p>First Name: ${user.firstName}</p>
    <p>Last Name: ${user.lastName}</p>

    <p>To enter another email address, click the Back button in your browser or the Return button shown below.</p>
    <form action="emailList" method="get">
        <input type="submit" value="Return">
    </form>
</body>
</html>