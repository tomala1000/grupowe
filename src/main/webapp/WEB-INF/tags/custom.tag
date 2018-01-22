<%@tag description="Example tag" pageEncoding="UTF-8"%>
<%@attribute name="student" required="true" type="org.sda.domain.Student"%>

Imie: ${student.firstName} <br>
Nazwisko: ${student.lastName} <br>
Zdal?: ${student.passed} <br>