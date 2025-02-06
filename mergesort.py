# Merge Sort function
def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2  # Find the middle point
        left_half = arr[:mid]  # Left half
        right_half = arr[mid:]  # Right half

        # Recursively split the array into halves
        merge_sort(left_half)
        merge_sort(right_half)

        i = j = k = 0

        # Merge the sorted halves
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        # Check if any element was left in left_half
        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        # Check if any element was left in right_half
        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1


# Take input from the user
user_input = input("Enter a list of numbers separated by spaces: ")
input_list = list(map(int, user_input.split()))

# Perform Merge Sort
merge_sort(input_list)

# Display the sorted list
print("Sorted list:", input_list)
