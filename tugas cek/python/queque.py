import queue 

# Read the dataset from file and store it in a list of dictionaries
data = []
with open('dataset.txt', 'r') as file:
    for line in file:
        name, major, height, weight, activity = line.strip().split(',')
        height = int(height)
        weight = int(weight)
        person = {'name': name, 'major': major, 'height': height, 'weight': weight, 'activity': activity}
        data.append(person)

# Create an empty Queue
q = queue.Queue()

# Get user input
search_criteria = input("Enter search criteria (1 = major, 2 = height, 3 = hobby): ")

if search_criteria == '1':
    # Search for individuals with a major in "Teknik Informatika"
    for person in data:
        if person['major'] == 'Teknik Informatika':
            q.put(person)

    # Print the individuals with a major in "Teknik Informatika"
    while not q.empty():
        person = q.get()
        print(f"Name: {person['name']}")
        print(f"Major: {person['major']}")
        print(f"Height: {person['height']} cm")
        print(f"Weight: {person['weight']} kg")
        print(f"Activity: {person['activity']}")
        print()

elif search_criteria == '2':
    # Search for individuals with a height over 160 cm
    for person in data:
        if person['height'] > 160:
            q.put(person)

    # Print the individuals with a height over 160 cm
    while not q.empty():
        person = q.get()
        print(f"Name: {person['name']}")
        print(f"Major: {person['major']}")
        print(f"Height: {person['height']} cm")
        print(f"Weight: {person['weight']} kg")
        print(f"Activity: {person['activity']}")
        print()

elif search_criteria == '3':
    # Search for individuals with hobbies in "Musik" and "Olahraga"
    for person in data:
        hobbies = person['activity'].split(',')
        if 'Musik' in hobbies and 'Olahraga' in hobbies:
            q.put(person)

    # Print the individuals with hobbies in "Musik" and "Olahraga"
    while not q.empty():
        person = q.get()
        print(f"Name: {person['name']}")
        print(f"Major: {person['major']}")
        print(f"Height: {person['height']} cm")
        print(f"Weight: {person['weight']} kg")
        print(f"Activity: {person['activity']}")
        print()


else:
    print("Invalid search criteria. Please enter 1, 2, or 3.")