/**
 * Description: This is the subclass that walks through the caves to find the scales. It walks through the tree(Mountain caves) and when it reaches the end leaf,
 *              but doesn't find the scales, it goes back to the parent(root) and looks at the other child(leaf). This also prints out the hunter's name and all 
 *              the caves the hunter has been in. It also calculates teh shortest path to the scales. This hunter is not able to smell for a nearby Wumpus as I 
 *              an not sure that that is suppose to mean. 
 *              
 * 
 * @author:      Sandy Chau 
 * @assignment:  Homework 9
 * 
 */

public class StackBasedWumpusHunter extends WumpusHunter {
    
    /**
     * Description: Gets the name of the hunter
     * @return: String Hunter
     *              
     */
    @Override
    public String getName() {
        return "Hunter";
    }

    /** Description: This will walk through the caves and report the names of the caves. If it does not find the scales, 
     *                it continues exploring the caves.
     *              
     */
    @Override
    public void startAt(MountainCave root) {
        boolean found = root.hasScales();    //whether the scales are found or not

        int i = 0;
        LinkedList scalesPath = new LinkedList(); //List to store the direction to the scales

        MountainCave current = root; //top of tree

        while (!found) {    //while scales are not found
            report(current); // Reports name of cave being entered
            scalesPath.insert(current,0);    //adds current cave
            
            
            if (current.getChildren().toArray().length == 0) {
                //If there are no more leaves, check t0 see if scales are found

                if (current.hasScales()) {    //if scales are found

                    found = true; //changes to true

                    if(found = true){
                        current.setHasScales(true);
                    }

                    actionLog += "\nThe scales have been found. \n";
                    actionLog += ("\n\nShortest path: \n");                                                            
                    actionLog += (scalesPath.toString());

                }else {    //if scales have not been found, explore other cave by finding other branch                  

                    current = findNextCave(current, scalesPath);

                }

            }else {
                //Continue on to other caves
                current = (MountainCave)current.getChildren().get(0);   

            }

        }

    }

    /**
     * Description: This finds the next cave to explore by finding when the current cave is equal to another
     *              cave in the tree and returning the next cave. 
     * @param: MountainCave current, LinkedList pathToScales
     * @return:MountainCave path (new cave to explore)
     */
    private MountainCave findNextCave(MountainCave current, LinkedList pathToScales) {
        pathToScales.remove(0); //deletes the last path from list

        MountainCave path = null;// used to find next path
        boolean foundNextCave = false;// used to break out of loop if a cave path has been found
        int temp =  current.getParent().getChildren().toArray().length;//find length of array

        //Find when the current cave is equal to the child leaf
        for (int i = 0; i < temp && !foundNextCave; i++) {

            //If they are equal return the next cave
            if (current.getParent().getChildren().get(i).equals(current)) {
                foundNextCave = true;
                path = (MountainCave) current.getParent().getChildren().get(i + 1);    //go to the next cave
            }

        }

        //goes back to the parent to find the child and next path
        if (path == null && current.hasParent()) {
            path = findNextCave(current.getParent(), pathToScales);
        }

        
        return path;
    } 

    /**
     * Description: Reports which caves the hunter is entering and also prints out message to 
     *              inform if scales are near
     * @param: MountainCave cave
     *              
     */
    private void report(MountainCave cave) { 
        //records the cave it is entering
        actionLog += "Entering " + cave.getCaveName() + " : " + cave.getCaveMessage() + "\n";

        //If the caved enter is adjacent to the place the sales are located, show message that it is near
        if (cave.isAdjacentToScales()) {
            actionLog += "\nThe scales are near \n\n";
        }
    }
}
