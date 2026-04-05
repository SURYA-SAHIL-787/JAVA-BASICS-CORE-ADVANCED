def bellman_ford(vertices, edges, start):
    """
    vertices: number of vertices
    edges: list of edges in form (u, v, w)
    start: source vertex
    """
    distances = [float('inf')] * vertices
    distances[start] = 0

    for _ in range(vertices - 1):
        updated = False

        for u, v, w in edges:
            if distances[u] != float('inf') and distances[u] + w < distances[v]:
                distances[v] = distances[u] + w
                updated = True

        if not updated:
            break

    for u, v, w in edges:
        if distances[u] != float('inf') and distances[u] + w < distances[v]:
            raise ValueError("Graph contains a negative weight cycle")

    return distances


# Example usage
vertices = 5
edges = [
    (0, 1, 6),
    (0, 2, 7),
    (1, 2, 8),
    (1, 3, 5),
    (1, 4, -4),
    (2, 3, -3),
    (2, 4, 9),
    (3, 1, -2),
    (4, 0, 2),
    (4, 3, 7)
]

start_node = 0

try:
    print("Shortest distances using Bellman-Ford:")
    print(bellman_ford(vertices, edges, start_node))
except ValueError as e:
    print(e)
