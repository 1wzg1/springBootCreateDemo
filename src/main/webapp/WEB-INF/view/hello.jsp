<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>test</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        $(document).ready(function(){
            $("p").click(function(){
                window.location.href = 'http://localhost:8888/excel/getUser';
            });
        });
    </script>
    </head>
    <body>
    <p>download</p>
</body>
</html>