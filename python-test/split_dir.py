import os
import os.path
import shutil

# this folder is custom
rootdir = "D:/works"

# for f in os.walk(rootdir):
#     print(f)
idx = 0;
for parent, dirnames, filenames in os.walk(rootdir):
    fullName = os.path.join(parent, filename)
    if idx == 100 :
        shutil.move(os.path.join(parent, filename),os.path.join(parent, filename))
        idx = 0
    # case 1:
    for dirname in dirnames:
        print("parent folder is:" + parent)
        print("dirname is:" + dirname)
        # case 2
    for filename in filenames:
        print("parent folder is:" + parent)
        print("filename with full path:" + os.path.join(parent, filename))