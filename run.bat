@echo off

rem 重命名javaw.exe为指定名称
copy "%JAVA_HOME%\bin\javaw.exe" "%JAVA_HOME%\bin\xfquartz-01.exe"

rem 使用指定名称的javaw.exe执行jar文件
start "lock-server" "%JAVA_HOME%\bin\xfquartz-01.exe" -jar xfquartz-0.0.1-SNAPSHOT.jar

exit