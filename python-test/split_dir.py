import os
import os.path
import shutil

# this folder is custom
rootdir = "H:\mumu_pictures\camera20171007"
SPLIT_LENGTH = 3000
# for f in os.walk(rootdir):
#     print(f)

for parent, dirnames, filenames in os.walk(rootdir):
    for dirname in dirnames:
        print("parent folder is:" + parent)
        print("dirname is:" + dirname)
        # case 2
    idx = 0;
    for filename in filenames:
        # print("parent folder is:" + parent)
        # print("filename with full path:" + os.path.join(parent, filename))
        idx = idx + 1
        if True:
            destDir = parent + "." + str(int(idx / SPLIT_LENGTH))
            if not(os.path.exists(destDir)):
                os.mkdir(destDir)
            shutil.move(os.path.join(parent, filename), os.path.join(destDir, filename))