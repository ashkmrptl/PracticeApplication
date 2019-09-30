package com.akp.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/*
 * ForkJoinPool is enhanced version of ExecutorService where each tasks can be broken down to sub-tasks, execute them and then join their results to get the final result. 
 */
public class ForkJoinPoolExample {
	public static void main(String[] args) {
		CustomRecursiveAction action = new CustomRecursiveAction("abcdefghijklmnopqrstuvwxyz");

		action.compute();
	}
}

class CustomRecursiveAction extends RecursiveAction {
	private static final long serialVersionUID = 1L;

	private String workload = "";
	private static final int THREASHOLD = 4;

	public CustomRecursiveAction(String workload) {
		this.workload = workload;
	}

	@Override
	protected void compute() {
		if (this.workload.length() > THREASHOLD) {
			ForkJoinTask.invokeAll(createSubTask());
		} else {
			processing();
		}
	}

	private List<CustomRecursiveAction> createSubTask() {
		List<CustomRecursiveAction> subTasksList = new ArrayList<CustomRecursiveAction>();
		String partOne = workload.substring(0, workload.length() / 2);
		String partTwo = workload.substring(workload.length() / 2, workload.length());

		subTasksList.add(new CustomRecursiveAction(partOne));
		subTasksList.add(new CustomRecursiveAction(partTwo));

		return subTasksList;

	}

	private void processing() {
		System.out.println("workload : " + workload + " by thread : " + Thread.currentThread().getName());
	}
}