def for_version(items):
   result = []
   for i in range(len(items) - 1, -1, -1):
      result.append(items[i])
   return result

def while_version(items):
   result = []
   i = len(items)-1
   while i >= 0:
      result.append(items[i])
      i = i-1
   return result
