def pop(self):
    if self.top is None:
        print("Stack is empty")
        return

    temp = self.top
    self.top = temp.next
    return temp.data
