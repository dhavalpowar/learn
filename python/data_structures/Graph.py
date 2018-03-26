class Graph(object):
    def __init__(self):
        pass
    
    class Node(self, data):
        self.data = data
        self.adjacent = []

        def __eq__(self, another):
            if self.data == another.data:
                return True
            else:
                return False

    def hasPathDFS(self, source, dest):
        visited = set()
        return self.hasPathDfsRec(source, dest, visited)

    def hasPathDfsRec(self, source, dest, visited):
        if source.data in visited:
            return False
        else:
            visited.add(source)
            if source == dest:
                return True
            for child in source.adjacent:
                if self.hasPathDfsRec(child, dest, visited):
                    return True
            return False

    def hasPathBFS(self, source, dest):
        nextToVisit = list()
        visited = set()
        nextToVisit.append(source)

        while not nextToVisit:
            popped = nextToVisit.pop(0)
            if popped == dest:
                return True
            else:
                if popped not in visited:
                    visited.add(popped)
                    # Add children to end of list
                    for child in popped.adjacent:
                        nextToVisit.append(child)
        
        return False
