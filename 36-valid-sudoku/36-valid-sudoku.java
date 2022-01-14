class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        /*
            fn valid(board):
                seeBox map<r|c, hashSet>
                loop over rows r:
                    seenRows hashSet
                    seenCols hashSet
                    loop over cols c:
                        check if value each cell r,c is present in seenRows
                        check if value each cell c,r is present in seenCols
                        check if value each cell r,c is present in r/3 | c/3 in seenBox
                        exit false if any of above happens
                exit true otherwise
        */
        
        if( board == null || board.length != 9 || board[0].length != 9) return false;
        
        int N = 9;
        Map<String, Set<Character>> boxSeen = new HashMap<>();
        Set<Character> rowSeen = new HashSet<>();
        Set<Character> colSeen = new HashSet<>();
            
        for(int i = 0; i < N; i ++){
            
            for(int j = 0; j < N; j ++){
                
                char rowChar = board[i][j];
                char colChar = board[j][i];
                
                if(rowChar != '.'){
                    if(rowSeen.contains(rowChar)){
                        return false;
                    }else{
                        rowSeen.add(rowChar);
                    }
                    
                    String boxKey = (i/3) + "|" + (j/3);
                    
                    if(boxSeen.containsKey(boxKey)){
                        if(boxSeen.get(boxKey).contains(rowChar)){
                            return false;
                        }else{
                            boxSeen.get(boxKey).add(rowChar);
                        }
                    }else{
                        boxSeen.put(boxKey, new HashSet<Character>());
                        boxSeen.get(boxKey).add(rowChar);
                    }
                }
                
                if(colChar != '.'){
                    if(colSeen.contains(colChar)){
                        return false;
                    }else{
                        colSeen.add(colChar);
                    }
                }
                
                
            }
            rowSeen.clear();
            colSeen.clear();
        }
        
                    return true;

    }
    
    
    
}

// [".",".",".",".","5",".",".","1","."],
// [".","4",".","3",".",".",".",".","."],
// [".",".",".",".",".","3",".",".","1"],
// ["8",".",".",".",".",".",".","2","."],
// [".",".","2",".","7",".",".",".","."],
// [".","1","5",".",".",".",".",".","."],
// [".",".",".",".",".","2",".",".","."],
// [".","2",".","9",".",".",".",".","."],
// [".",".","4",".",".",".",".",".","."]