def push(self, data):
    new_node = Node(data)
    new_node.next = self.top
    self.top = new_node
