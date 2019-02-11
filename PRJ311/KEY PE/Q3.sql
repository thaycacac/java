<--DELETE-->
DELETE FROM dbo.StudentInfomation WHERE StudentId = ?

<--UPDATE-->
UPDATE dbo.StudentInfomation SET StudentName = ?, DepartId = ?, Gender = ?, Age = ? WHERE StudentId = ?

<--SEARCH ALL-->
SELECT s.DepartId, s.StudentName, d.DepartName, s.Gender, s.Age
FROM dbo.StudentInfomation s, dbo.DepartInfomation d\n
WHERE s.DepartId = d.DepartId\n
AND (s.StudentName LIKE '%" + txtSearch.getText() + "%'
OR s.Gender LIKE '%" + txtSearch.getText() + "%'
OR s.Age LIKE '%" + txtSearch.getText() + "%'
OR d.DepartName LIKE '%" + txtSearch.getText() + "%')

<--SEARCH-->
SELECT * FROM dbo.StudentInfomation s, dbo.DepartInfomation d
WHERE s.DepartId = d.DepartId\n
AND d." + cbxField.getSelectedItem().toString()"
LIKE '%" + txtSearch.getText() + "%'

<--SEARCH SELECT CHECKBOX-->
SELECT s.DepartId, s.StudentName, d.DepartName, s.Gender, s.Age
FROM dbo.StudentInfomation s, dbo.DepartInfomation d
WHERE s.DepartId = d.DepartId
AND (
((chbStudentName.isSelected() && !chbAge.isSelected() && !chbGender.isSelected() && !chbDepartment.isSelected()) ? "s.StudentName LIKE '%" + txtSearch.getText() + "%'" : "")
((chbGender.isSelected() && (chbStudentName.isSelected() || chbAge.isSelected() || chbDepartment.isSelected())) ? " OR s.Gender LIKE '%" + txtSearch.getText() + "%'" : "")
((chbGender.isSelected() && !chbStudentName.isSelected() && !chbAge.isSelected() && !chbDepartment.isSelected()) ? " s.Gender LIKE '%" + txtSearch.getText() + "%'" : "")
((chbAge.isSelected() && (chbStudentName.isSelected() || chbGender.isSelected() || chbDepartment.isSelected())) ? " OR s.Age LIKE '%" + txtSearch.getText() + "%'" : "")
((chbAge.isSelected() && !chbStudentName.isSelected() && !chbGender.isSelected() && !chbDepartment.isSelected()) ? " s.Age LIKE '%" + txtSearch.getText() + "%'" : "")
((chbDepartment.isSelected() && (chbStudentName.isSelected() || chbGender.isSelected() || chbAge.isSelected())) ? " OR d.DepartName LIKE '%" + txtSearch.getText() + "%'" : "")
((chbDepartment.isSelected() && !chbStudentName.isSelected() && !chbGender.isSelected() && !chbAge.isSelected()) ? " d.DepartName LIKE '%" + txtSearch.getText() + "%'" : "")
)
<--INSERT-->
INSERT INTO dbo.StudentInfomation(StudentId, StudentName, DepartId, Gender, Age) VALUES(?, ?, ?, ?, ?)

<--SELECT-->
SELECT s.StudentId, s.StudentName, d.DepartName,s.Gender, s.Age
FROM dbo.StudentInfomation s, dbo.DepartInfomation d
WHERE s.DepartId=d.DepartId

<--SELECT WITH CONDITION-->
SELECT b.title_id, b.title_id,
(CASE WHEN b.pub_id = '05740' THEN 'True'
ELSE 'False'
END) AS 'NameColumn', b.username
FROM dbo.Books b


