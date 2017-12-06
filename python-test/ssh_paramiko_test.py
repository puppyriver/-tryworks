import paramiko
import sys
hostname = '135.251.223.141'
port = 22
username = 'root'
password = 'Rut123!@#'
client = paramiko.SSHClient()  # 绑定实例
client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
client.connect(hostname, port, username, password, timeout=5)
stdin, stdout, stderr = client.exec_command('df -k')   # 执行bash命令
result = stdout.read()
error = stderr.read()
# 判断stderr输出是否为空，为空则打印执行结果，不为空打印报错信息
if not error:
    print(str(result,'utf-8'))
else:
    print(str(error,'utf-8'))
client.close()