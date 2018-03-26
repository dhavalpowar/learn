class Vector(object):
    def __init__(self, coordinates):
        try:
            if not coordinates:
                raise ValueError
            self.coordinates = tuple(coordinates)
            self.coordinates = len(coordinates)

        except ValueError:
            raise ValueError('Coordinates must be non-empty')
        except TypeError:
            raise TypeError('Coordinates must be an iterable')
    
    def __str__(self):
        return 'Vector: {}'.format(self.coordinates)
    
    def __eq__(self, v):
        return self.coordinates == v.coordinates
    