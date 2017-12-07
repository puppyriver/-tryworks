import paramiko
import sys
hostname = '135.251.223.141'
port = 22
username = 'sbell'
password = 'Sbell@123'
client = paramiko.SSHClient()  # 绑定实例
client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
client.connect(hostname, port, username, password, timeout=5)

rootPassword = "Rut123!@#"
channel = client.invoke_shell()
try:
    channel.send("su - root\n")
    while not channel.recv_ready():
        print("Working...")
        # time.sleep(2)
    print(str(channel.recv(1024),"utf-8"))
    channel.send("%s\n" % rootPassword)
    while not channel.recv_ready():
        print("Authenticating...")
        #time.sleep(2)
    print(str(channel.recv(1024),"utf-8"))
    channel.send("id\n")
    while not channel.recv_ready():
        print("Working on part 3...")
        #time.sleep(10)
    print(str(channel.recv(1024),"utf-8"))
except Exception as e:
    print("error:"+e)


stdin, stdout, stderr = client.exec_command('id')   # 执行bash命令
result = stdout.read()
error = stderr.read()
# 判断stderr输出是否为空，为空则打印执行结果，不为空打印报错信息
if not error:
    print(str(result,'utf-8'))
else:
    print(str(error,'utf-8'))


client.close()