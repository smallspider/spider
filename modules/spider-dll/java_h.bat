echo off

set configFile=config.txt
set logFile=log.txt
set jniDir=jni

rem ����ļ��Ƿ����
if not exist %configFile% (
	echo �����ļ�������!
	goto end
	)
	
if not exist %jniDir% (
	  md \%jniDir%
	)


rem ���浱ǰ·��

set configFile=config.txt
cd bin
rem ��ȡconfig.txt�ļ�����
FOR /F "eol=;skip=1 tokens=1,2,3,4 delims=, " %%i in (%configFile%) do (
    rem echo %%i %%j %%k %%l
    if %%i==jni (
        if %%l==true (
        	javah -d ..\jni -classpath . -jni %%k
        )
    ) 
)
cd ../
rem ��ԭ�ϴα���Ŀ¼

:end

rem pause