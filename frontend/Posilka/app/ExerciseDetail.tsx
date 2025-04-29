import React, { useEffect, useState } from 'react';
import { ScrollView, StyleSheet, View } from 'react-native';
import { Avatar, Button, Card, Title, Paragraph, Text } from 'react-native-paper';
import { SvgUri } from 'react-native-svg';
import { Exercise } from '@/types/Exercise';
import { getExerciseById } from '@/app/api/ExerciseService'; 
import { useLocalSearchParams } from 'expo-router';

const ExerciseDetail = () => {
  const { exerciseId } = useLocalSearchParams();
  const [exercise, setExercise] = useState<Exercise | null>(null);

  useEffect(() => {
    const id = Number(exerciseId);
    if (isNaN(id)) {
      console.warn('Invalid exerciseId:', exerciseId); 
      return;
    }

    const fetchExerciseDetail = async () => {
      try {
        const response = await getExerciseById(id);
        setExercise(response.data);
      } catch (error) {
        console.error('Error fetching exercise details:', error);
      }
    };

    fetchExerciseDetail();
  }, [exerciseId]);

  if (!exercise) {
    return (
      <View style={styles.container}>
        <Text>Loading...</Text>
      </View>
    );
  }

  return (
    <ScrollView style={styles.container}>
      <Card.Content>
  <View style={styles.imageContainer}>
    <View style={styles.imageBackground}>
      {exercise.mediaUrl?.endsWith('.svg') ? (
        <SvgUri width="100" height="100" uri={exercise.mediaUrl} />
      ) : (
        <SvgUri width="100" height="100" uri="https://www.svgrepo.com/download/382003/exercise-health-fitness-weight.svg"/>
      )}
    </View>
  </View>

  <Title style={styles.title}>{exercise.name}</Title>

  <Paragraph style={styles.text}><Text style={styles.icon}>💪</Text> Muscle Group: {exercise.muscleGroup}</Paragraph>
  <Paragraph style={styles.text}><Text style={styles.icon}>⚙️</Text> Difficulty: {exercise.difficulty}</Paragraph>
  <Paragraph style={styles.text}><Text style={styles.icon}>📋</Text> Instructions: {exercise.instructions}</Paragraph>
</Card.Content>

<View style={styles.divider} />

<Card.Actions>
  <Button style={styles.button} labelStyle={styles.buttonText} onPress={() => console.log('Edit')}>
    Edit
  </Button>
</Card.Actions>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  button:{
    backgroundColor: '#D1F5FF',
  },
  buttonText:{
    color: '#333'
  },
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: '#f4f4f4',
  },
 
  imageContainer: {
    alignItems: 'center',
    marginBottom: 15,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#333',
  },
  text: {
    fontSize: 16,
    marginBottom: 10,
    color: '#333',
  },
  icon: {
    fontSize: 16,
    marginRight: 6,
  },
  
  divider: {
    height: 1,
    backgroundColor: '#ddd',
    marginVertical: 10,
    marginHorizontal: 10,
  },
  
  imageBackground: {
    backgroundColor: '#E6F7FA',
    padding: 16,
    borderRadius: 100,
  },
});

export default ExerciseDetail;