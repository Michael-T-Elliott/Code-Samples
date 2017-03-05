def poly_add2(poly1, poly2):
    return [poly1[0] + poly2[0], poly1[1] + poly2[1], poly1[2] + poly2[2]]

def poly_mult2(poly1, poly2):
    return [(poly1[2]*poly2[2])+(poly1[2]*poly2[1])+(poly1[2]*poly2[0]), (poly1[1]*poly2[2])+(poly1[1]*poly2[1])+(poly1[1]*poly2[0]),(poly1[0]*poly2[2])+(poly1[0]*poly2[1])+(poly1[0]*poly2[0])]
