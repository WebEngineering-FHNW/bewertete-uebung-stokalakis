@echo off
:Ask
echo Laptop (1) or PC (2)?
set /P INPUT=
If /I "%INPUT%"=="1" goto laptop 
If /I "%INPUT%"=="2" goto pc

:laptop
set createApp_l=""
set runApp_l=""
set stopApp_l=""

echo Laptop: Copy/create/run/stop grails app? (o/c/r/s)
set /P INPUT=
If /I "%INPUT%"=="o" goto copy_l
cd ""
If /I "%INPUT%"=="c" start call "%createApp_l%"
If /I "%INPUT%"=="r" start call "%runApp_l%"
If /I "%INPUT%"=="s" start call "%stopApp_l%"

goto laptop

:pc
set createApp_p=D:\Documents\Dropbox\01 FHNW\01 Unterricht\08 8. Semester, FS 17\02_4iCbb_webeC\vscode_workspace\bewertete-uebung-stokalakis\custom_bats\createApp.bat
set runApp_p=D:\Documents\Dropbox\01 FHNW\01 Unterricht\08 8. Semester, FS 17\02_4iCbb_webeC\vscode_workspace\bewertete-uebung-stokalakis\custom_bats\runApp.bat
set stopApp_p=D:\Documents\Dropbox\01 FHNW\01 Unterricht\08 8. Semester, FS 17\02_4iCbb_webeC\vscode_workspace\bewertete-uebung-stokalakis\custom_bats\stopApp.bat

echo PC: Copy/create/run/stop grails app? (o/c/r/s)
set /P INPUT=
If /I "%INPUT%"=="o" goto copy_p
D:
cd D:\webeC_Repo\bewertete-uebung-stokalakis
If /I "%INPUT%"=="c" start call "%createApp_p%"
If /I "%INPUT%"=="r" start call "%runApp_p%"
If /I "%INPUT%"=="s" start call "%stopApp_p%"

goto pc

:copy_l
set srcfile_l=""
set destfile_l=""
rmdir ""
xcopy /s "%srcfile_l%" "%destfile_l%"
goto laptop

:copy_p
D:
set srcfile_p=D:\Documents\Dropbox\01 FHNW\01 Unterricht\08 8. Semester, FS 17\02_4iCbb_webeC\vscode_workspace\bewertete-uebung-stokalakis
set destfile_p=D:\webeC_Repo\bewertete-uebung-stokalakis
rmdir D:\webeC_Repo\bewertete-uebung-stokalakis /s /q
xcopy /s "%srcfile_p%" "%destfile_p%"
goto pc