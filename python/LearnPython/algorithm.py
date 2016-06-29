
def removeElement(self, A, elem):
    ret = 0
    for item in A:
        if item != elem:
            A[ret] = item
            ret += 1

    return ret
