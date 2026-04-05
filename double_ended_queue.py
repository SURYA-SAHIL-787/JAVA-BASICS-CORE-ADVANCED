class Deque:
    def __init__(self, size):
        self.size = size
        self.deque = [None] * size
        self.front = -1
        self.rear = -1

    # Check if deque is empty
    def is_empty(self):
        return self.front == -1

    # Check if deque is full
    def is_full(self):
        return (self.rear + 1) % self.size == self.front

    # Insert at front
    def insert_front(self, value):
        if self.is_full():
            print("Deque is Full")
            return

        if self.is_empty():
            self.front = 0
            self.rear = 0
        elif self.front == 0:
            self.front = self.size - 1
        else:
            self.front -= 1

        self.deque[self.front] = value
        print(f"Inserted {value} at front")

    # Insert at rear
    def insert_rear(self, value):
        if self.is_full():
            print("Deque is Full")
            return

        if self.is_empty():
            self.front = 0
            self.rear = 0
        else:
            self.rear = (self.rear + 1) % self.size

        self.deque[self.rear] = value
        print(f"Inserted {value} at rear")

    # Delete from front
    def delete_front(self):
        if self.is_empty():
            print("Deque is Empty")
            return None

        value = self.deque[self.front]

        if self.front == self.rear:
            self.front = -1
            self.rear = -1
        else:
            self.front = (self.front + 1) % self.size

        print(f"Deleted {value} from front")
        return value

    # Delete from rear
    def delete_rear(self):
        if self.is_empty():
            print("Deque is Empty")
            return None

        value = self.deque[self.rear]

        if self.front == self.rear:
            self.front = -1
            self.rear = -1
        elif self.rear == 0:
            self.rear = self.size - 1
        else:
            self.rear -= 1

        print(f"Deleted {value} from rear")
        return value

    # Get front element
    def get_front(self):
        if self.is_empty():
            print("Deque is Empty")
            return None
        return self.deque[self.front]

    # Get rear element
    def get_rear(self):
        if self.is_empty():
            print("Deque is Empty")
            return None
        return self.deque[self.rear]

    # Display deque
    def display(self):
        if self.is_empty():
            print("Deque is Empty")
            return

        i = self.front
        print("Deque elements:", end=" ")

        while True:
            print(self.deque[i], end=" ")
            if i == self.rear:
                break
            i = (i + 1) % self.size
        print()


# Example usage
dq = Deque(5)

dq.insert_rear(10)
dq.insert_rear(20)
dq.insert_front(5)
dq.insert_front(2)

dq.display()

dq.delete_front()
dq.delete_rear()

dq.display()

print("Front element:", dq.get_front())
print("Rear element:", dq.get_rear())
