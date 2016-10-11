import os, sys, re, shutil

if __name__ == '__main__':

    used_map = {}
    resPath = "./MagnetPF/Res/"
    depDir = "Deprecated"
    skipDir = ["message"]

    for root, dirs, files in os.walk("./"):
        for file in files:
                if file.endswith(".m"):

                    filepath = os.path.join(root, file)
                    f = open(filepath, "r")

                    for line in f:
                        match = re.findall(".*?@\"(Res.*?.png)\".*?", line)

                        if match:
                            for image in match:
                                used_map[image] = 1


    skipDir.append(depDir)

    for root, dirs, files in os.walk(resPath):
            for file in files:

                orginfile = os.path.join(root, file)

                match = re.findall(".*?(Res.*?.png).*?", orginfile)

                if match:
                    matchfile = match[0].replace("@2x","").replace("@3x","")

                    print matchfile

                    if not used_map.has_key(matchfile):

                        filename = orginfile.split(os.path.sep)[-1]
                        relPath = orginfile.replace(resPath,"")
                        originDir = relPath.split(os.path.sep)[0]
                        tofile = resPath + depDir + "/" + relPath
                        topath = tofile.replace(filename,"")

                        if not  originDir in skipDir:
                            if not os.path.exists(topath):
                                os.mkdir(topath)

                                print "from: " + orginfile
                                print "  to:" + tofile
                                print ""

                                shutil.move(orginfile, tofile)