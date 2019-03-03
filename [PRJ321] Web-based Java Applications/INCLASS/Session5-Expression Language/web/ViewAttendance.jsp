
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="myStyle.css" rel="stylesheet">
    </head>
    <body>
s        <form action="/Session2-JSP/Result">
            <div class="container">
                <p class="myTitle">Single activity Attendance</p>
                <br>
                <a href="#" class="myCode">Edit this Attendance</a>
                <p>Attendance for
                    <span class="mySpan">PRJ321</span> with leacturer
                    <span class="mySpan">Duong TB</span>
                    at slot 4 on Monday 13/08/2018, in room HB/305L at FU-HL</p>
                <div class="myTableField">
                    <div class="myItemField">No</div>
                    <div class="myItemField">Group</div>
                    <div class="myItemField">Code</div>
                    <div class="myItemField">Name</div>
                    <div class="myItemField">Absent</div>
                    <div class="myItemField">Present</div>
                    <div class="myItemField">Comment</div>
                    <div class="myItemField">Show Image</div>
                </div>
                <div class="myTable">
                    <div class="myItem myNo">1</div>
                    <div class="myItem">
                        <a href="#">PRJ321.E-B5</a>
                    </div>
                    <div class="myItem myCode">SE03335</div>
                    <div class="myItem">
                        <a href="#">Cao Bá Khánh Linh</a>
                    </div>
                    <div class="myItem">
                        <input type="radio" name="student1" value="absent"> Absent
                    </div>
                    <div class="myItem">
                        <input type="radio" name="student1" value="present"> Present
                    </div>
                    <div class="myItem"></div>
                    <div class="myItem">
                        <img src="1.PNG" alt="">
                    </div>
                </div>
                <div class="myTable">
                    <div class="myItem">1</div>
                    <div class="myItem">
                        <a href="#">PRJ321.E-B5</a>
                    </div>
                    <div class="myItem myCode">SE03555</div>
                    <div class="myItem">
                        <a href="#">Phan Lâm</a>
                    </div>
                    <div class="myItem">
                        <input type="radio" name="student2" value="absent"> Absent
                    </div>
                    <div class="myItem">
                        <input type="radio" name="student2" value="present"> Present
                    </div>
                    <div class="myItem"></div>
                    <div class="myItem">
                        <img src="2.PNG" alt="">
                    </div>
                </div>
                <div class="myTable">
                    <div class="myItem">1</div>
                    <div class="myItem">
                        <a href="#">PRJ321.E-B5</a>
                    </div>
                    <div class="myItem myCode">SE03810</div>
                    <div class="myItem">
                        <a href="#">Nguyễn Minh Hiếu</a>
                    </div>
                    <div class="myItem">
                        <input type="radio" name="student3" value="absent"> Absent
                    </div>
                    <div class="myItem">
                        <input type="radio" name="student3" value="present"> Present
                    </div>
                    <div class="myItem"></div>
                    <div class="myItem">
                        <img src="3.PNG" alt="">
                    </div>  
                </div>
            </div>
            <div class="button">
                <input type="submit" value="Add" class="myButton">
            </div>
        </form>
    </body>
</html>
