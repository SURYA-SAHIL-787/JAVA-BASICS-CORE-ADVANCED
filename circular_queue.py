class CircularQueue:
    def __init__(self, size):
        self.size = size
        self.queue = [None] * size
        self.front = -1
        self.rear = -1

    # Check if queue is empty
    def is_empty(self):
        return self.front == -1

    # Check if queue is full
    def is_full(self):
        return (self.rear + 1) % self.size == self.front

    # Insert element
    def enqueue(self, value):
        if self.is_full():
            print("Queue is Full")
            return

        # First element
        if self.is_empty():
            self.front = 0
            self.rear = 0
        else:
            self.rear = (self.rear + 1) % self.size

        self.queue[self.rear] = value
        print(f"Inserted {value}")

    # Remove element
    def dequeue(self):
        if self.is_empty():
            print("Queue is Empty")
            return None

        value = self.queue[self.front]

        # Only one element
        if self.front == self.rear:
            self.front = -1
            self.rear = -1
        else:
            self.front = (self.front + 1) % self.size

        print(f"Removed {value}")
        return value

    # Display queue
    def display(self):
        if self.is_empty():
            print("Queue is Empty")
            return

        i = self.front
        print("Queue elements:", end=" ")

        while True:
            print(self.queue[i], end=" ")
            if i == self.rear:
                break
            i = (i + 1) % self.size
        print()


# Example usage
cq = CircularQueue(5)

cq.enqueue(10)
cq.enqueue(20)
cq.enqueue(30)
cq.enqueue(40)
cq.enqueue(50)

cq.display()

cq.dequeue()
cq.dequeue()

cq.display()

cq.enqueue(60)
cq.enqueue(70)

cq.display()
