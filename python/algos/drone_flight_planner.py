def calc_drone_min_energy(route):
    if len(route) == 1:
        return 0
    energy_needed = 0
    energy_gained = 0
    for i in range(1, len(route)):
        # When the drone ascends, see if there is gained energy
        # If yes, see if more energy is needed.
        if route[i][2] > route[i-1][2]:
            energy_expensed = route[i][2] - route[i-1][2]
            if (energy_gained - energy_expensed) < 0:
                energy_needed += abs(energy_gained - energy_expensed)
                energy_gained = 0
            else:
                energy_gained = energy_gained - energy_expensed
        else:
            energy_gained += (route[i-1][2] - route[i][2])
    return energy_needed
      
  
if __name__ == '__main__':
    r = [ [0,   2, 10],
        [3,   5,  0],
        [9,  20,  6],
        [10, 12, 15],
        [10, 10,  8] ]
    print(calc_drone_min_energy(r))