using System;

namespace ConsoleApp2
{
// https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/range-minimum-query/description/
    class Program
    {
        static void Main(string[] args)
        {
            var query1 = Console.ReadLine();

            var split = query1.Split(' ');
            int n = int.Parse(split[0]);
            int q = int.Parse(split[1]);
            var input = new int[n];
            var query = Console.ReadLine().Split(' ');
            for (int i = 0; i < n; ++i)
            {
                input[i] = int.Parse(query[i]);
            }
            int size = (int)(Math.Log(n) / Math.Log(2)) + 1;
            int segSize = 2 * (1 << size);
            var seg = new int[segSize];
            build(input, seg, 1, 0, n - 1);

            for (int i = 0; i < q; ++i)
            {
                query = Console.ReadLine().Split(' ');

                if (query[0] == "q")
                {
                    var res = find(seg, 1, int.Parse(query[1]) - 1, int.Parse(query[2]) - 1, 0, n - 1);
                    Console.WriteLine(res);
                }
                else
                {
                    update(input, seg, 1, 0, n - 1, int.Parse(query[1]) - 1, int.Parse(query[2]));
                }
            }
        }
        static void update(int[] arr, int[] seg, int idx, int s, int e, int node, int val)
        {
            if (s == e)
            {
                arr[node] = val;
                seg[idx] = val;
                return;
            }
            if (node >= s && node <= (s + e) / 2)
            {
                update(arr, seg, idx * 2, s, (s + e) / 2, node, val);
            }
            else
            {
                update(arr, seg, idx * 2 + 1, (s + e) / 2 + 1, e, node, val);
            }
            seg[idx] = Math.Min(seg[idx * 2], seg[idx * 2 + 1]);
        }
        static int find(int[] seg, int idx, int x, int y, int s, int e)
        {
            if (x < s || y > e) return int.MaxValue;
            if (x >= s && y <= e)
            {
                return seg[idx];
            }
            int mid = (s + e) / 2;
            return Math.Min(find(seg, idx * 2, x, mid, s, e), find(seg, idx * 2 + 1, mid + 1, y, s, e));
        }

        static int build(int[] input, int[] seg, int idx, int s, int e)
        {
            if (s == e)
            {
                return seg[idx] = input[s];
            }
            build(input, seg, idx * 2, s, (s + e) / 2);
            build(input, seg, idx * 2 + 1, (s + e) / 2 + 1, e);
            return seg[idx] = Math.Min(seg[idx * 2], seg[idx * 2 + 1]);
        }
    }
}
