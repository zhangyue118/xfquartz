@echo off

rem ������javaw.exeΪָ������
copy "%JAVA_HOME%\bin\javaw.exe" "%JAVA_HOME%\bin\xfquartz-01.exe"

rem ʹ��ָ�����Ƶ�javaw.exeִ��jar�ļ�
start "lock-server" "%JAVA_HOME%\bin\xfquartz-01.exe" -jar xfquartz-0.0.1-SNAPSHOT.jar

exit