def search(self, key):
    temp = self.top
    while temp:
        if temp.data == key:
            return True
        temp = temp.next
    return False
