@echo off

set GRADLE_HOME=E:\PROJECT_REPO_CODEBASE\REPO_PROJECTS\REPOSITORY\GRADLE_BUILD_REPO\build-tools\gradle-4.10.2
set PATH=%GRADLE_HOME%\bin;%PATH%

echo Setting GRADLE Home: %GRADLE_HOME%

gradle -v
