class Solution {
private:
    ListNode* makeList(vector<int>& nums) {
        ListNode* dummy = new ListNode(-1);
        ListNode* curr = dummy;

        for(int x : nums) {
            curr->child = new ListNode(x);
            curr = curr->child;
        }

        return dummy->child;
    }

public:
    ListNode* flattenLinkedList(ListNode* head) {
        vector<int> nums;

        while(head) {
            ListNode* temp = head;

            while(temp) {
                nums.push_back(temp->val);
                temp = temp->child;
            }

            head = head->next;
        }

        sort(nums.begin(), nums.end());

        return makeList(nums);
    }
};
