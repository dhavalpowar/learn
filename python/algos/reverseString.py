from sys import argv

def reverseWords(s):
        """
        :type s: str
        :rtype: str
        """
        
        if len(s) == 0:
            return s
        
        if len(s) == 1 and s[0] == " ":
            return ""

        # Brute force: Tokenize on space, add it to list
        l = s.split()
        r = " ".join(l[::-1])

        return r

reverseWords(argv[1])

