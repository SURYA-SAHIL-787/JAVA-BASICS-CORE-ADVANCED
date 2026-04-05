import math

def floyd_warshall(matrix):
    """
    matrix: adjacency matrix
    use math.inf if there is no direct edge
    """
    n = len(matrix)
    dist = [row[:] for row in matrix]

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][k] != math.inf and dist[k][j] != math.inf:
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

    return dist


# Example usage
INF = math.inf

graph = [
    [0,   3,   INF, 7],
    [8,   0,   2,   INF],
    [5,   INF, 0,   1],
    [2,   INF, INF, 0]
]

result = floyd_warshall(graph)

print("Shortest distances using Floyd-Warshall:")
for row in result:
    print(row)
