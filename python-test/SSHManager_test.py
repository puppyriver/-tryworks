from autonomation import SSHManager

ssh = SSHManager()
ssh.connect("135.251.223.141", username="sbell", password="Sbell@123")

ssh.su("root","Rut123!@#")

comands = [
    "id",
    "pwd"
]

for cmd in comands:
    if cmd == "./deploy":
        resp = ssh.exec_interative_cmd(cmd, timeout=20)  # para eu ter mais informações do deploy
    else:
        resp = ssh.exec_interative_cmd(cmd)
        print("resp = %s" % resp)
    #print(resp)
    print("/"*10)

ssh.close()